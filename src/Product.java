public record Product(int productId) {

    @Override
    public String toString() {
        return "Продукт %s".formatted(productId);
    }
}
