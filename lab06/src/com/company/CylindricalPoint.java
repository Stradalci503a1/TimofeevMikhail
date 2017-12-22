package com.company;

public class CylindricalPoint extends PolarPoint {

    private double z;

    CylindricalPoint(double rho, double phi, double z){
        super(rho, phi);
        this.z = z;
    }

    public double getRho(){
        return super.getRho();
    }

    public double getPhi(){
        return super.getPhi();
    }

    public double getZ() {
        return z;
    }

    @Override
    Point toCartesian(){
        return new Point(super.getRho() * Math.cos(super.getPhi()), super.getRho() * Math.sin(super.getPhi()), z);
    }
}
