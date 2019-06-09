package br.com.unicesumar.aep.voo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class BilheteAereo {

    private Integer voo;
    private String origem;
    private String destino;
    private Date data;
}
