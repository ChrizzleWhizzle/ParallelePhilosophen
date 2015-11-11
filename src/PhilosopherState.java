public enum PhilosopherState {

    HUNGRY(1,2,10,5),NORMAL(1,5,10,3);

    private int eatTime;
    private int meditateTime;
    private int sleepTime;
    private int maxMealsEaten;
    private PhilosopherState(int eatTime,int meditateTime, int sleepTime,int maxMealsEaten){
        this.eatTime = eatTime;
        this.meditateTime = meditateTime;
        this.sleepTime = sleepTime;
        this.maxMealsEaten = maxMealsEaten;
    }
}
