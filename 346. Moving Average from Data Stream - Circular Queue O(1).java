class MovingAverage {

    int size;
    int[] values;
    int currSize;
    int currSum;

    public MovingAverage(int size) {
        this.size = size;
        this.values = new int[size];    
        this.currSize = 0;
        this.currSum = 0;
    }
    
    public double next(int val) {
        int index = currSize % size;
        int temp = values[index];
        values[index] = val;
        currSum += val - temp;
        currSize++;
        int min = Math.min(currSize, size);
        return (double) currSum/min;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
