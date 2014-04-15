RollerCoaster

Montanha Russa
======

Suponha que haja N Threads de passageiros e uma única thread de carro.

Os passageiros, repetidamente, esperam para andar no carro, que comporta C passageiros, C < N.

O carro só pode partir depois que estiver cheio.

(a) Passageiros devem invocar embarcar() e desembarcar()

(b) O carro deve invocar carregar(), andar() e descarregar()

(c) Passageiros não podem embarcar até que o carro tenha invocado carregar()

(d) O carro não pode partir até que C passageiros tenham embarcado.

(e) Passageiros não podem desembarcar até que o carro tenha invocado descarregar()



Theres N threads of passengers and only one thread of car.

The passengers waits to ride the car, that have a C size, C < N.

The car only can leave after completely filled.

(a) Passengers must call methots named embarcar() and desembarcar()

(b) The car must call the methods carregar(), andar() and descarregar()

(c) Passengers can't board until the car calls carregar()

(d) The car can't depart until C passengers are aboard

(e) Passengers can't leave until the car have calls descarregar()