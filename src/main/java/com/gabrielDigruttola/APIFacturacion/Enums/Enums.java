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

        private int value;
        private TipoEvento(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum Moneda {
        ARS(1),
        USD(2);

        private int value;
        private Moneda(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum EstadoCargo {
        PENDIENTE_DE_PAGO(1),
        PAGADO(2);

        private int value;
        private EstadoCargo(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
