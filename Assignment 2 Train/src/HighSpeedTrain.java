public class HighSpeedTrain extends Train{
    HighSpeedTrain(){}
    public HighSpeedTrain(int trainId, String trainName, int wagonAmount, String direction, String date){
        super(trainId, trainName, wagonAmount, direction, date, 200);
    }
}
