package com.bintime.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Contains request id.
 *
 * @author Krukovskiy Arthur
 *
 */
@Entity
@Table(name = "uploadrequest")
public class UploadRequest extends BaseEntity{
    public UploadRequest() {}

    public UploadRequest(Integer id) {
        super(id);
    }
}
