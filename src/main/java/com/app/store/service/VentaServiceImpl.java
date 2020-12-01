package com.app.store.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.store.dao.VentaDao;
import com.app.store.dto.TVenta;
import com.app.store.dto.TVentaDetalle;
import com.app.store.entity.Venta;
import com.app.store.entity.VentaDetalle;
import com.app.store.service.util.Constants.OBSERV;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	VentaDao ventaDao;

	@Override
	public List<Venta> findAllSales() {
		List<Venta> ventas = new ArrayList<>();
		ventaDao.findAll().forEach(x -> ventas.add(setVenta(x)));
		return ventas;
	}

	private Venta setVenta(TVenta x) {
		Venta v = new Venta();
		v.setFecha(x.getFecha());
		v.setIdCliente(x.getIdCliente());
		v.setIdVenta(x.getIdVenta());
		List<VentaDetalle> det = new ArrayList<VentaDetalle>();
		x.getDetalle().stream().forEach(y -> det.add(setVentaD(y)));
		v.setDetalle(det);
		return v;
	}

	private VentaDetalle setVentaD(TVentaDetalle x) {
		VentaDetalle det = new VentaDetalle();
		det.setIdDetalleVenta(x.getIdVentaD());
		det.setIdProducto(x.getIdProducto());
		det.setIdVenta(x.getVenta().getIdVenta());
		return det;
	}

	@Override
	public Venta createSale(Venta venta) {
		TVenta bean= new TVenta();
		bean.setFecha(venta.getFecha());
		bean.setIdCliente(venta.getIdCliente());
		bean.setIdVenta(venta.getIdVenta());
		bean.setAudit_dfecope(null);
		bean.setAudit_vobs(OBSERV.CREATE);
		bean.setAudit_vuser("ROOT");
		bean.setAudit_dfecre(LocalDateTime.now());
		
		List<TVentaDetalle> det = new ArrayList<TVentaDetalle>();
		for(VentaDetalle beanD: venta.getDetalle()) {
			TVentaDetalle d = new TVentaDetalle();
			d.setIdProducto(beanD.getIdProducto());
			d.setIdVentaD(beanD.getIdDetalleVenta());
			d.setVenta(bean);
			det.add(d);
		}
		bean.setDetalle(det);
		bean = ventaDao.save(bean);
		return setVenta(bean);
	}

	@Override
	public Venta findSale(Long id) {
		Optional<TVenta> venta= ventaDao.findById(id);
		if(venta.isPresent()) {
			return setVenta(venta.get());
		}else {
			return null;
		}
	}

}
