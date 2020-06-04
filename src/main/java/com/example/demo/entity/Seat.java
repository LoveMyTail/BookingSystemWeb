package com.example.demo.entity;

public class Seat {
    private Integer seatId;
    private Integer showId;
    private Integer coordinateX;
    private Integer coordinateY;
    private Boolean choosen;
    private Boolean status;

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Boolean getChoosen() {
        return choosen;
    }

    public void setChoosen(Boolean choosen) {
        this.choosen = choosen;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
