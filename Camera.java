package ca.georgiancollege.comp1011summer2024tuesdays;

public class Camera {

 private String lens = "", sensor = "", color = "", make = "", model = "";
 private int numberOfPhotosTaken, yearReleased = 2024;
 private float videoHoursRecorded;

 private void validate(String title, String data) {
  if (data.trim().isEmpty()) {
    throw new IllegalArgumentException(title + " is too short. Needs to be at least 1 character");
  }
 }

 public String getLens() {
  return lens;
 }

 public void setLens(String lens) {
  validate("Lens", lens);
  this.lens = lens;
 }

 public String getSensor() {
  return sensor;
 }

 public void setSensor(String sensor) {
  validate("Sensor", sensor);
  this.sensor = sensor;
 }

 public String getColor() {
  return color;
 }

 public void setColor(String color) {
  validate("Color", color);
  this.color = color;
 }

 public String getMake() {
  return make;
 }

 public void setMake(String make) {
  validate("Make", make);
  this.make = make;
 }

 public String getModel() {
  return model;
 }

 public void setModel(String model) {
  validate("Model", model);
  this.model = model;
 }

 public Camera(String model, String make, String color, String sensor, String lens) {
  setModel(model);
  setMake(make);
  setColor(color);
  setSensor(sensor);
  setLens(lens);
 }

 public Camera() {}

 public boolean takePicture(int howMany) {
  numberOfPhotosTaken += howMany;
  return true;
 }

 public boolean recordVideo(float howLong) {
  videoHoursRecorded += howLong;
  return true;
 }

 public boolean isOldCamera() {
  int currentYear = 2024;
  return currentYear - yearReleased >= 3;
 }

 public boolean displayVideo(String... filters) {
  for (String filter : filters) {
   System.out.println("Applying filter: " + filter);
  }
  return true;
 }

 @Override
 public String toString() {
  return "Camera{" +
          "lens='" + lens + '\'' +
          ", sensor='" + sensor + '\'' +
          ", color='" + color + '\'' +
          ", make='" + make + '\'' +
          ", model='" + model + '\'' +
          '}';
 }
}
