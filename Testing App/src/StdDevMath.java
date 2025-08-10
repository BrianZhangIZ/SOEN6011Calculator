public final class StdDevMath {
    private StdDevMath() {}

    public static double stddev(double[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Values must be non-empty");
        }
        double sum = 0.0;
        for (double v : values) sum += v;
        double mean = sum / values.length;

        double sq = 0.0;
        for (double v : values) {
            double diff = v - mean;
            sq += diff * diff;
        }
        return Math.sqrt(sq / values.length); // population σ
    }
}
