package ModuloMetricasInnovatech.Metricas.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class MetricaHistoricaDTO {
    private Integer id;
    private String nombreKpi;
    private Float valorCalculado;
    private LocalDate fechaCalculo;
}