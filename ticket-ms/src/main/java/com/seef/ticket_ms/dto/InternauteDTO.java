package com.seef.ticket_ms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternauteDTO {

    private long idInternaute;
    private String identifiant;
    private TrancheAge trancheAge;

}