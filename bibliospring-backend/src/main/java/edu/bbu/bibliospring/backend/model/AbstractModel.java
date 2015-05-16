/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bbu.bibliospring.backend.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

/**
 *
 * @author zsvitalyos
 */
@MappedSuperclass
public class AbstractModel implements Serializable {
    @Column (name="uuid", nullable=false, length=36, unique=true)
    private String uuid;

    @Override
    public int hashCode () {
        return getUuid().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractModel other = (AbstractModel) obj;
        if ((this.getUuid() == null) ? (other.getUuid() != null)
                : !this.getUuid().equals(other.getUuid())) {
            return false;
        }
        return true;

    }
    
    public String getUuid() {
        ensureUuid();
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    @PrePersist
    public void onPrePersist () {
        ensureUuid();
    }
    private void ensureUuid () {
        if (uuid == null) {
            setUuid(UUID.randomUUID().toString());
        }
    }
}
