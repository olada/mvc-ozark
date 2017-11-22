package de.cofinpro.techat.mvcozark.techatplanner.beanparam;

import de.cofinpro.techat.mvcozark.shared.formparam.Datum;
import de.cofinpro.techat.mvcozark.shared.formparam.Uhrzeit;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

/**
 * Created by David Olah on 22.11.2017.
 */
@Data
public class TechatEvent {
    @NotNull
    @FormParam("thema")
    private String thema;

    @NotNull
    @Size(min = 3)
    @FormParam("vortragende")
    private String vortragende;

    @FormParam("date")
    @Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}")
    private Datum date;

    @FormParam("time")
    @Pattern(regexp = "\\d{2}:\\d{2}")
    private Uhrzeit time;
}
