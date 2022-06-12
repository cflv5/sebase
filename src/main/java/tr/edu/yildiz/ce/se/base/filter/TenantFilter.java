package tr.edu.yildiz.ce.se.base.filter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import tr.edu.yildiz.ce.se.base.context.TenantContext;
import tr.edu.yildiz.ce.se.base.context.TenantFactory;
import tr.edu.yildiz.ce.se.base.domain.HeaderConstants;

@Component
public class TenantFilter extends OncePerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TenantFilter.class);

    private static final List<String> excludedURLs = List.of("/v1/api/user/login", "/v1/api/user/register");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        LOGGER.info("Intercepting request.");
        var tenantId = request.getHeader(HeaderConstants.TENANT_ID);
        var accessToken = request.getHeader(HeaderConstants.ACCESS_TOKEN);

        if (Objects.isNull(tenantId) || tenantId.isEmpty()) {
            LOGGER.info("No tenant found");
            response.sendError(HttpStatus.UNAUTHORIZED.value());
        } else {
            if (request.getServletPath().contains("/internal/")
                    && (Objects.isNull(accessToken) || accessToken.isBlank())) {
                LOGGER.info("No service access token found");
                response.sendError(HttpStatus.UNAUTHORIZED.value());
                return;
            }
            TenantContext.setCurrentTenant(TenantFactory.createTenant(tenantId));
            LOGGER.info("Tenant set with id {}", tenantId);
            filterChain.doFilter(request, response);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        var path = request.getServletPath();
        boolean match = excludedURLs.stream().anyMatch(p -> StringUtils.pathEquals(p, path));
        if (match) {
            LOGGER.info("Not filtering path {}", path);
        } else {
            LOGGER.info("Filtering path {}", path);
        }
        return match;
    }

}
