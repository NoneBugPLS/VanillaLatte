package com.zelin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.io.Serializable;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes implements Serializable {
    @Id
    private Integer cid;
    private String cname;

}