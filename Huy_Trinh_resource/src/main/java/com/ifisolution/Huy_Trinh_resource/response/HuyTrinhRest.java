package com.ifisolution.Huy_Trinh_resource.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HuyTrinhRest {
    private String name;
    private String dob;
    private int height;
    private String careerStatus;
    private String quote;
    private String crush;
    private String hobbies;
}
