package es.curso.spring.basico.eventos;

import org.springframework.context.ApplicationEvent;

public class MiEvento extends ApplicationEvent {
	public MiEvento(Object source) {
		super(source);
	}
}
