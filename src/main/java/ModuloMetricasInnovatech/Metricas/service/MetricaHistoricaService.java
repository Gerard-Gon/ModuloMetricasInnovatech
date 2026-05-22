package ModuloMetricasInnovatech.Metricas.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ModuloMetricasInnovatech.Metricas.dto.MetricaHistoricaDTO;
import ModuloMetricasInnovatech.Metricas.model.MetricaHistorica;
import ModuloMetricasInnovatech.Metricas.repository.MetricaHistoricaRepository;

@Service
public class MetricaHistoricaService {

    @Autowired
    private MetricaHistoricaRepository metricaRepository;

    public List<MetricaHistorica> getAllMetricas() {
        return metricaRepository.findAll();
    }

    public MetricaHistorica getMetricaById(Integer id) {
        return metricaRepository.findById(id).orElse(null);
    }

    // Crear una metrica a partir de un DTO
    public MetricaHistorica crear(MetricaHistoricaDTO dto) {
        MetricaHistorica metrica = new MetricaHistorica();
        metrica.setNombreKpi(dto.getNombreKpi());
        metrica.setValorCalculado(dto.getValorCalculado());
        // Si no mandan fecha, ponemos la de hoy por defecto
        metrica.setFechaCalculo(dto.getFechaCalculo() != null ? dto.getFechaCalculo() : java.time.LocalDate.now()); 
        return metricaRepository.save(metrica);
    }

    public MetricaHistorica saveMetrica(MetricaHistorica metrica) {
        return metricaRepository.save(metrica);
    }

    public void deleteMetrica(Integer id) {
        metricaRepository.deleteById(id);
    }
}