package ModuloMetricasInnovatech.Metricas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ModuloMetricasInnovatech.Metricas.model.MetricaHistorica;

@Repository
public interface MetricaHistoricaRepository extends JpaRepository<MetricaHistorica, Integer> {
    // Aquí puedes agregar consultas personalizadas a futuro
}