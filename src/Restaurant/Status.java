package Restaurant;

import java.io.Serializable;

public enum Status implements Serializable {
    SERVED,
    PAID,
    ACTIVE;

    Status() {
    }
}
