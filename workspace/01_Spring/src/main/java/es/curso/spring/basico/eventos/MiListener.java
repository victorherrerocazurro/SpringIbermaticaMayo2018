package es.curso.spring.basico.eventos;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//@Component
public class MiListener implements ApplicationListener<MiEvento> {
	public void onApplicationEvent(MiEvento event) {
		System.out.println("Se ha lanzado un evento de inicio: " + event.getSource());
	}
}
