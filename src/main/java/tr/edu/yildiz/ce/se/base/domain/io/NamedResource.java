package tr.edu.yildiz.ce.se.base.domain.io;

import org.springframework.core.io.ByteArrayResource;

public class NamedResource extends ByteArrayResource {
    private final String name;

    public NamedResource(byte[] byteArray, String name) {
        super(byteArray);
        this.name = name;
    }

    @Override
    public String getFilename() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        NamedResource other = (NamedResource) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
