package com.gabrielDigruttola.APIFacturacion.Enums;

public class Enums {
    public enum TipoEvento {
        INDEFINIDO(0),
        CLASIFICADO(1),
        VENTA(2),
        PUBLICIDAD(3),
        ENVIO(4),
        CREDITO(5),
        MERCADOPAGO(6),
        MERCADOSHOP(7),
        FIDELIDAD(8);

        private int id;
        private TipoEvento(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static TipoEvento fromId(int id) {
            for (TipoEvento evento : values()) {
                if (evento.id == id)
                    return evento;
            }
            return null;
        }
    }

    public enum Moneda {
        INDEFINIDO(0),
        ARS(1),
        USD(2);


        private int id;
        private Moneda(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public enum EstadoCargo {
        PENDIENTE_DE_PAGO(1),
        PAGADO(2);

        private int id;
        private EstadoCargo(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static EstadoCargo fromId(int id) {
            for (EstadoCargo estado : values()) {
                if (estado.id == id)
                    return estado;
            }
            return null;
        }
    }
}
