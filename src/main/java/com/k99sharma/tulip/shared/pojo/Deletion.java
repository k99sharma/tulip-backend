package com.k99sharma.tulip.shared.pojo;

import lombok.*;

/**
 * Deletion POJO
 * Class to send deletion status.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Deletion {
    private Boolean deleted;

    @Override
    public boolean equals(Object o){
        if(! (o instanceof Deletion))
            return false;

        // type cast object
        Deletion deletion = (Deletion) o;
        if(deletion.getDeleted() != this.deleted)
            return false;

        return true;
    }

    @Override
    public int hashCode(){
        return Boolean.hashCode(deleted);
    }
}
