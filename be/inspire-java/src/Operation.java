public enum Operation {
    ADD {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
    SUBTRACT {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            if (y == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
            return x / y;
        }
    };

    // 각 상수에서 구현해야 하는 추상 메서드
    public abstract double apply(double x, double y);
}
