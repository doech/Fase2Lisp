
(defun suma (lista)
  (cond
    ((null lista) 0)
    (t (+ (car lista) (suma (cdr lista))))))


(defun contar-elementos (lista)
  (cond
    ((null lista) 0)  
    (t (+ 1 (contar-elementos (cdr lista))))))  


(defun calcular-promedio (calificaciones)
  (/ (suma calificaciones) (contar-elementos calificaciones)))


(defun aprueba-p (promedio)
  (cond
    ((>= promedio 60) t)  
    (t nil))) 


(defun procesar-calificaciones ()
  (let* ((calificaciones '(75 80 68 90 85))
         (promedio (calcular-promedio calificaciones)))
    (format t "Las calificaciones son: ~a~%" calificaciones)
    (format t "El promedio es: ~f~%" promedio)  
    (cond
      ((aprueba-p promedio) 
       (format t "Ganaste la clase!~%"))
      (t  
       (format t "Lo siento, perdiste la clase.~%")))))

(procesar-calificaciones)
