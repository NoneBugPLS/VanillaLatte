package com.zelin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Companyinfo implements Serializable {
    private Integer cid;

    private String compname;

    private String ownername;

    private String ownertel;

    private String compinfo;

}