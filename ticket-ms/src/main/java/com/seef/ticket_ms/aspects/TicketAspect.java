package com.seef.ticket_ms.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TicketAspect {

    @AfterThrowing(
            pointcut = "execution(* com.seef.ticket_ms.services.TicketService.ajouterTicketsEtAffecterAEvenementEtInternaute(..))",
            throwing = "exception")
    public void handleUnsupportedOperationException(UnsupportedOperationException exception) {
        // Affichage du message lorsque l'exception est lancée
        System.err.println("Le nombre de places restantes dépasse le nombre de tickets demandés");
    }
}
