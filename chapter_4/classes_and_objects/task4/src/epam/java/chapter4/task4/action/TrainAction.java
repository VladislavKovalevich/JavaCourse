package epam.java.chapter4.task4.action;

import epam.java.chapter4.task4.entity.Train;

public class TrainAction {
    public TrainAction(){

    }

    public Train[] sortTrainArrayByNumber(Train[] trains){

        for (int i = 0; i < trains.length - 1; i++) {

            for (int j = trains.length - 1; j > i; j--) {

                if (trains[j - 1].getNumber() > trains[j].getNumber()){

                    Train temp;
                    temp = trains[j - 1];
                    trains[j - 1] = trains[j];
                    trains[j] = temp;
                }

            }

        }

        return trains;
    }

    public StringBuilder getInfoAboutTrainByNumber(Train[] trains, int number){
        StringBuilder infoBuilder;
        Train train;

        infoBuilder = new StringBuilder("Информация о поезде с номером ");
        infoBuilder.append(number).append(": ");

        train = null;

        for (Train currTrain: trains) {

            if (currTrain.getNumber() == number){
                train = currTrain;
                break;
            }

        }

        if (train != null) {
            infoBuilder.append(train.toString());
        }else{
            infoBuilder.append("Поезда с данным номером не существует");
        }

        return infoBuilder;
    }

    public Train[] sortTrainArrayByArrivalPoint(Train[] trains){

        for (int i = 0; i < trains.length - 1; i++) {

            for (int j = trains.length - 1; j > i; j--) {

                if (compareInfoAboutTrains(trains[j-1], trains[j]) == 1){

                    Train temp;
                    temp = trains[j - 1];
                    trains[j - 1] = trains[j];
                    trains[j] = temp;
                }

            }

        }

        return trains;
    }

    private int compareInfoAboutTrains(Train train, Train train1) {
        int result;

        result = 0;

        if (train.getArrivalPoint().compareTo(train1.getArrivalPoint()) > 0) {

            result = 1;

        }else {
            if (train.getArrivalPoint().compareTo(train1.getArrivalPoint()) == 0){

                if (train.getDepartureDate().getTime() > train1.getDepartureDate().getTime()){
                    result = 1;
                }
            }
        }

        return result;
    }
}
