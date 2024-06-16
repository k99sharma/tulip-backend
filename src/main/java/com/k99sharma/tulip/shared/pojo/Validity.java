package com.k99sharma.tulip.shared.pojo;

import lombok.*;

/**
 * Validity POJO
 * Class to send validity status.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Validity {
    private Boolean valid;

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Validity))
            return false;

        // type cast object
        Validity validity = (Validity) o;

        if(validity.getValid() != this.valid)
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        return Boolean.hashCode(valid);
    }
}
