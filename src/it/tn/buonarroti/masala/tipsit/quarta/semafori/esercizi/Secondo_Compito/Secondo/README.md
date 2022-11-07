Creare due thread.
Il primo avrà il ruolo di produttore, il secondo di consumatore.
Il thread produttore dovrà produrre risorse da inserire in una struttura dati.
Il thread consumatore dovrà consumare le risorse dalla struttura dati.
Il thread consumatore non puó consumare risorse se queste non sono presenti nella struttura dati.
Il thread consumatore consuma una risorsa ogni dai 2 ai 7 secondi, mentre il thread produttore ne produce una ogni 4 secondi.