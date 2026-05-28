package ModuloMetricasInnovatech.Metricas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "metricas_historicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricaHistorica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_kpi", nullable = false, length = 150)
    private String nombreKpi;

    @Column(name = "valor_calculado", nullable = false)
    private Float valorCalculado;

    @Column(name = "fecha_calculo", nullable = false)
    private LocalDate fechaCalculo;

    @Column(name = "proyecto_id", nullable = true) // Puede ser null si hay métricas globales
    private Integer proyectoId;
    
}