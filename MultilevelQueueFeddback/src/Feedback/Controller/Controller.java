package Feedback.Controller;

import Feedback.Model.Model;

import java.util.ArrayList;

public class Controller {
    Model model = new Model();
    ArrayList<Model> jobQueue = new ArrayList<Model>();
    ArrayList<Model> terminateQueue = new ArrayList<Model>();
    ArrayList<Model> queue1 = new ArrayList<Model>();
    ArrayList<Model> queue2 = new ArrayList<Model>();
    ArrayList<Model> queue3 = new ArrayList<Model>();
    ArrayList<Model> cdQueue = new ArrayList<Model>();
    int pId = 1;  //ProcessID กําหนดให้เริ่มต้นที่ ProcessID = 1
    int timeQuantumQ1 = 0;
    int timeQuantumQ2 = 0;
    int burstTime = 0; //ค่า burstTime
    int resetTimeQuantumQ1;
    int resetTimeQuantumQ2;
    int waitingTime = 0; // ใช้เก็บค่า WaitingTime
    int ioTime = 0;  // ใช้ กำหนดช่วงเวลาทำงานของ IO
    double avgWaitingTime = 0;
    double avgTurnaroundTime = 0;

    public Controller() {
    }

    ////////////////////////////////////////addProcess////////////////////////////////////////////////////////////////////////////
    //method ปุ่ม addProcess คือมี paramiter อยู่ 2 ตัว รับมาจากฝั่ง View คือตัวแปล clock timeQuantum Method นี้จะถูกนําไปเรียกใช้ในฝั่ง View
    public void addProcess(int clock, int timeQuantumQ1, int timeQuantumQ2) {
        model = new Model(pId, 0, clock, 1, timeQuantumQ1);
        resetTimeQuantumQ2 = timeQuantumQ2;
        pId++;
        jobQueue.add(model);
        queue1.add(model);
    }


    ////////////////////////////////////////process////////////////////////////////////////////////////////////////////////////

    // Method roundRobinQueue จะทำการกำหนดค่าต่างๆ การทํางานต่างๆ ในกรณีที่เข้าไปใช้งาน CPU
    public void queue1() {
        try {
            for (int i = 0; i < jobQueue.size(); i++) {
                if (queue1.get(0) == jobQueue.get(i)) {
                    timeQuantumQ1 = jobQueue.get(i).getTimeQuantum();
                    timeQuantumQ1--;
                    jobQueue.get(i).setTimeQuantum(timeQuantumQ1);

                    burstTime = jobQueue.get(i).getBurstTime();
                    burstTime++;
                    jobQueue.get(i).setBurstTime(burstTime);
                    jobQueue.get(i).setStatus(2);

                    if (jobQueue.get(i).getTimeQuantum() == 0) {
                        jobQueue.get(i).setStatus(1);
                        jobQueue.get(i).setTimeQuantum(resetTimeQuantumQ2);
                        jobQueue.get(i).setQueue(jobQueue.get(i).getQueue() + 1);
                        queue2.add(jobQueue.get(i));
                        queue1.remove(0);

                    }
                } else if (jobQueue.get(i).getStatus() != "Waiting") {
                    jobQueue.get(i).setStatus(1);
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    public void queue2() {
        try {
            for (int i = 0; i < jobQueue.size(); i++) {
                if (queue2.get(0) == jobQueue.get(i)) {
                    timeQuantumQ2 = jobQueue.get(i).getTimeQuantum();
                    timeQuantumQ2--;
                    jobQueue.get(i).setTimeQuantum(timeQuantumQ2);

                    burstTime = jobQueue.get(i).getBurstTime();
                    burstTime++;
                    jobQueue.get(i).setBurstTime(burstTime);
                    jobQueue.get(i).setStatus(2);

                    if (jobQueue.get(i).getTimeQuantum() == 0) {
                        jobQueue.get(i).setStatus(1);
                        jobQueue.get(i).setQueue(jobQueue.get(i).getQueue() + 1);
                        queue3.add(jobQueue.get(i));
                        queue2.remove(0);
//                        jobQueue.get(i).setTimeQuantum(resetTimeQuantumQ2);
                    }
                } else if (jobQueue.get(i).getStatus() != "Waiting") {
                    jobQueue.get(i).setStatus(1);
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    public void queue3() {
        //TODO firstComeFirstServed
        try {
            for (int i = 0; i < jobQueue.size(); i++) { //Loop ถ้า i = 0 เช็คว่า i < jobQueue.size ก็จะเพื่มค่า i ครั้งละ 1
                if (queue3.get(0) == jobQueue.get(i)) { // ถ้า firstComeFirstServedQueue ตําแหน่งที่ 0 เท่ากับ jobQueue ตําแหน่งที่ i
                    jobQueue.get(i).setStatus(2); // ก็จะเซ็ตค่าเป็น Running
                    burstTime = jobQueue.get(i).getBurstTime();   //โดย get ค่า jQ Process นั้นมา ให้มีค่าเท่ากับ burstTime
                    burstTime++;  //และเพิ่มค่า jQ ขึ้นที่ละ 1
                    jobQueue.get(i).setBurstTime(burstTime); //โดยนําค่า jQ มาเก็บยัง setBurstTime ของ Process นั้น
                } else if (jobQueue.get(i).getStatus() != "Waiting") {
                    jobQueue.get(i).setStatus(1);
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    public void running() {
        try {
            if (!queue1.isEmpty()) {
                queue1();
            }
            if (queue1.isEmpty() && !queue2.isEmpty()) {
                queue2();
            }
            if (queue1.isEmpty() && queue2.isEmpty() && !queue3.isEmpty()) {
                queue3();
            }

        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    public void removeQueue(int clock) {
        try {
            for (int i = 0; i < jobQueue.size(); i++) {
                if (jobQueue.get(i).getStatus() == "Running") {
                    jobQueue.get(i).setStatus(4);
                    terminateQueue.add(jobQueue.get(i));
                    if (jobQueue.get(i) == queue1.get(0)) {
                        queue1.remove(0);
                    }
                    else if (jobQueue.get(i) == queue2.get(0)) {
                        queue2.remove(0);
                    }
                    else if (jobQueue.get(i) == queue3.get(0)) {
                        queue3.remove(0);
                    }
                    jobQueue.remove(i);
                }
            }
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }
    public void waitingTime() {
        for (int i = 0; i < jobQueue.size(); i++) { //Loop ถ้า i = 0 เช็คว่า i < jobQueue.size ก็จะเพื่มค่า i ครั้งละ 1
            if (jobQueue.get(i).getStatus() == "Ready") {  // ถ้า jobQueue ตําแหน่งที่ i เท่ากับ "Ready"
                waitingTime = jobQueue.get(i).getWaitingTime();  //โดย get ค่า waitingTime มาใช้งาน
                waitingTime++; //เพิ่มค่า waitingTime ขึ้นทีละ 1
                jobQueue.get(i).setWaitingTime(waitingTime);//โดยนําค่า waitingTime มาเก็บยัง setBurstTime ของ Process นั้น

            }
        }
    }

    public void avgWaitingTime(int waitingTime) {
        this.avgWaitingTime = this.avgWaitingTime + waitingTime;
    }

    public String getAvgWaitingTime() {
        if (terminateQueue.isEmpty()) {
            return "0";
        } else
            return String.format("%.2f", avgWaitingTime / terminateQueue.size());
    }

    public void avgTurnaroundTime(int turnaroundTime) {
        this.avgTurnaroundTime = this.avgTurnaroundTime + turnaroundTime;
    }

    public String getAvgTurnaroundTime() {
        if (terminateQueue.isEmpty()) {
            return "0";
        } else
            return String.format("%.2f", avgTurnaroundTime / terminateQueue.size());
    }

    /////////////////////////////////////////////IO///////////////////////////////////////////////////////////////
    public void cdQueue() {
        try {
            ioTime = cdQueue.get(0).getIoTime();
            ioTime++;
            cdQueue.get(0).setIoTime(ioTime);
        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    //Method Add Process ไปยัง monitorQueue มาจาก roundRobinQueue หรือ firstComeFirstServedQueue
    public void addMonitorQueue() {
        try {

        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    //Method End MonitorQueue กลับไปยัง roundRobinQueue หรือ firstComeFirstServedQueue
    public void endCdQueue() {
        try {

        } catch (java.lang.IndexOutOfBoundsException e) {

        }
    }

    public void waitingTimeCdQueue() {
        for (int i = 1; i < cdQueue.size(); i++) { //Loop ถ้า i = 1 เช็คว่า i < monitorQueue.size ก็จะเพื่มค่า i ครั้งละ 1
            if (cdQueue.get(i).getStatus() == "Waiting") {  // ถ้า monitorQueue ตําแหน่งที่ i เท่ากับ "Waiting"
                waitingTime = cdQueue.get(i).getWaitingTime();  //โดย get ค่า waitingTime มาใช้งาน
                waitingTime++; //เพิ่มค่า waitingTime ขึ้นทีละ 1
                cdQueue.get(i).setWaitingTime(waitingTime);//โดยนําค่า waitingTime มาเก็บยัง setBurstTime ของ Process นั้น

            }
        }
    }

    ////////////////////////////////////////Show////////////////////////////////////////////////////////////////////////////
    //Method สำหรับ set ค่าเริ่มต้นให้กับ index ฝั่ง view
//    public int setIndexRr() {
//        int index = 0;
//        if (!roundRobinQueue.isEmpty())
//            if (roundRobinQueue.get(0).getStatus() == "Running") {
//                index = 1;
//            } else {
//                index = 0;
//            }
//
//        return index;
//    }

//    public int setIndexFcfs() {
//        int index = 0;
//        if (!firstComeFirstServedQueue.isEmpty()) {
//            if (firstComeFirstServedQueue.get(0).getStatus() == "Running") {
//                index = 1;
//            } else {
//                index = 0;
//            }
//        }
//        return index;
//    }

    //Method showJobQueue  จะทำการเอาค่าตัวแปรมาเก็บไว้ในตัวแปรที่ชื่อว่า text แล้วจะนำไปเรียกใช้ที่ฝั่ง View
    //Method ที่ชื่อว่า Show โดยทั้งหมดแล้วจะถูกเรียกใช้ที่ฝั่ง View เหมือนกัน
    public String showJobQueue() {
        String text = "";
        for (int index = 0; index < jobQueue.size(); index++) {
            text = text + jobQueue.get(index).getProcessID() + " ";
            text = text + jobQueue.get(index).getBurstTime() + " ";
            text = text + jobQueue.get(index).getArrivalTime() + " ";
            text = text + jobQueue.get(index).getWaitingTime() + " ";
            text = text + jobQueue.get(index).getStatus() + " ";
            text = text + jobQueue.get(index).getIoTime() + " ";
            text = text + jobQueue.get(index).getQueue() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showQueue1() {
        String text = "";
        for (int index = 0; index < queue1.size(); index++) {
            text = text + queue1.get(index).getProcessID() + " ";
            text = text + queue1.get(index).getStatus() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showQueue2() {
        String text = "";
        for (int index = 0; index < queue2.size(); index++) {
            text = text + queue2.get(index).getProcessID() + " ";
            text = text + queue2.get(index).getStatus() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showQueue3() {
        String text = "";
        for (int index = 0; index < queue3.size(); index++) {
            text = text + queue3.get(index).getProcessID() + " ";
            text = text + queue3.get(index).getStatus() + " ";
            text = text + ",";
        }
        return text;
    }

    public String showTerminateQueue() {
        String text = "";
        for (int index = 0; index < terminateQueue.size(); index++) {
            text = text + terminateQueue.get(index).getProcessID() + " ";
            text = text + terminateQueue.get(index).getStatus() + " ";
            text = text + terminateQueue.get(index).getWaitingTime() + " ";
            text = text + terminateQueue.get(index).getTurnaroundTime() + " ";
            text = text + ",";
        }
        return text;
    }
//
//    public String showCPU() {
//        String text = "";
//        for (int index = 0; index < jobQueue.size(); index++) {
//            if (jobQueue.get(index).getStatus() == "Running") {
//                text = text + jobQueue.get(index).getProcessID() + " ";
//                text = text + jobQueue.get(index).getStatus() + " ";
//                text = text + (jobQueue.get(index).getCountPercent() + 1) + " ";
//                text = text + ",";
//            }
//
//        }
//        return text;
//    }
//
//    public String showMonitor() {
//        String text = "";
//        for (int index = 0; index < monitorQueue.size(); index++) {
//            text = text + monitorQueue.get(0).getProcessID() + " ";
//            text = text + monitorQueue.get(0).getStatus() + " ";
//            text = text + monitorQueue.get(0).getIoTime() + " ";
//            text = text + ",";
//        }
//        return text;
//    }
//
//    public String showMonitorQueue() {
//        String text = "";
//        for (int index = 0; index < monitorQueue.size(); index++) {
//            text = text + monitorQueue.get(index).getProcessID() + " ";
//            text = text + monitorQueue.get(index).getStatus() + " ";
//            text = text + monitorQueue.get(index).getWaitingTime() + " ";
//            text = text + ",";
//        }
//        return text;
//    }
//
//    public String showUsb() {
//        String text = "";
//        for (int index = 0; index < usbQueue.size(); index++) {
//            text = text + usbQueue.get(0).getProcessID() + " ";
//            text = text + usbQueue.get(0).getStatus() + " ";
//            text = text + usbQueue.get(0).getIoTime() + " ";
//            text = text + ",";
//        }
//        return text;
//    }
//
//    public String showUsbQueue() {
//        String text = "";
//        for (int index = 0; index < usbQueue.size(); index++) {
//            text = text + usbQueue.get(index).getProcessID() + " ";
//            text = text + usbQueue.get(index).getStatus() + " ";
//            text = text + usbQueue.get(index).getWaitingTime() + " ";
//            text = text + ",";
//        }
//        return text;
//    }

}