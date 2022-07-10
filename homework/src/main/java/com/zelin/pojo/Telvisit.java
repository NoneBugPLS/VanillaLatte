package com.zelin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Telvisit implements Serializable {
    private Integer tvid;

    private String telname;

    private Date teltime;

    private String visitreason;

    private String visitreturn;

    private String visittype;

    private Integer cid;

}