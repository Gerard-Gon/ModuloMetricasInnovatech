package ModuloMetricasInnovatech.Metricas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ModuloMetricasInnovatech.Metricas.dto.MetricaHistoricaDTO;
import ModuloMetricasInnovatech.Metricas.model.MetricaHistorica;
import ModuloMetricasInnovatech.Metricas.service.MetricaHistoricaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/metricas-historicas")
public class MetricaHistoricaController {

    @Autowired
    private MetricaHistoricaService metricaService;

    @GetMapping
    @Operation(summary = "Obtener la lista de todas las métricas históricas")
    public ResponseEntity<List<MetricaHistorica>> getAllMetricas() {
        List<MetricaHistorica> metricas = metricaService.getAllMetricas();
        if (metricas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metricas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una métrica histórica específica por su ID")
    public ResponseEntity<MetricaHistorica> getMetricaById(@PathVariable Integer id) {
        MetricaHistorica metrica = metricaService.getMetricaById(id);
        if (metrica == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(metrica);
    }

    @PostMapping
    @Operation(summary = "Crear una nueva métrica histórica")
    public ResponseEntity<MetricaHistorica> createMetrica(@RequestBody MetricaHistoricaDTO dto) {
        MetricaHistorica createdMetrica = metricaService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMetrica);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar los datos de una métrica histórica existente")
    public ResponseEntity<MetricaHistorica> updateMetrica(@PathVariable Integer id, @RequestBody MetricaHistorica metrica) {
        if (metricaService.getMetricaById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        metrica.setId(id);
        MetricaHistorica updatedMetrica = metricaService.saveMetrica(metrica);
        return ResponseEntity.ok(updatedMetrica);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una métrica histórica del sistema")
    public ResponseEntity<Void> deleteMetrica(@PathVariable Integer id) {
        if (metricaService.getMetricaById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        metricaService.deleteMetrica(id);
        return ResponseEntity.noContent().build();
    }

    
}