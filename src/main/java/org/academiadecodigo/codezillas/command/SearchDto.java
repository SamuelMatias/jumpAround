package org.academiadecodigo.codezillas.command;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class SearchDto {

    @NotBlank(message = "Country is mandatory")
    private String country;
    @NotBlank(message = "Jumps is mandatory")
    private int jumps;
    @NotBlank(message = "Origin is mandatory")
    private String origin;
    @NotBlank(message = "CheckIn is mandatory")
    private Date checkIn;
    @NotBlank(message = "CheckOut is mandatory")
    private Date checkOut;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getJumps() {
        return jumps;
    }

    public void setJumps(int jumps) {
        this.jumps = jumps;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
