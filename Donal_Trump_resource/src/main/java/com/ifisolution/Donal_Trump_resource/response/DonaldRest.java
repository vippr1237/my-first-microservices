package com.ifisolution.Donal_Trump_resource.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonaldRest {
    private String name;
    private String dob;
    private int height;
    private String careerStatus;
    private String quote;
}
