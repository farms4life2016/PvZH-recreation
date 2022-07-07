
export class Random {

    //Math.random() returns a random number from [0, 1]

    /**
     * Returns a random integer in the interval [lower, upper]. I.e. both endpoints are included.
     * @param {Number} lower 
     * @param {Number} upper 
     * @returns {Number}
     */
    public static randint(lower: number, upper: number): number {

        //swap the variables around if they are not in the correct order
        if (lower > upper) {
            let temp = lower;
            lower = upper;
            upper = temp;
        }

        //start rng
        let diff = upper - lower + 1;
        let ans = Math.floor(Math.random() * diff) + lower;

        return ans;
    }

}

