package com.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample {
	public static void main(String[] args) {
		String rec1 = "/Users/virag/eclipse-workspace/Java-Practice/target/rec1.class";
		SerializeToFile(new Rectangle(2, 5), rec1);
		Rectangle obj1 = (Rectangle) DeSerializeFromFile(rec1);
		System.out.println(obj1.getArea());
	}

	public static void SerializeToFile(Object classObject, String fileName) {
		try {

			// Step 1: Open a file output stream to create a file object on disk.
			// This file object will be used to write the serialized bytes of an object
			try (FileOutputStream fileStream = new FileOutputStream(fileName)) {
				// Step 2: Create a ObjectOutputStream, this class takes a files stream.
				// This class is responsible for converting the Object of any type into
				// a byte stream
				try (ObjectOutputStream objectStream = new ObjectOutputStream(fileStream)) {
					objectStream.writeObject(classObject);

					// Step 4: Gracefully close the streams
					objectStream.close();
					fileStream.close();
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Object DeSerializeFromFile(String fileName) {
		Object deserializeObject = null;
		try {
			// Step 1: Open a file output stream to create a file object on disk.
			// This file object will be used to write the serialized bytes of an object
			try (FileInputStream fileStream = new FileInputStream(new File(fileName))) {
				// Step 2: Create a ObjectOutputStream, this class takes a files stream.
				// This class is responsible for converting the Object of any type into
				// a byte stream
				try (ObjectInputStream objectStream = new ObjectInputStream(fileStream)) {
					deserializeObject = objectStream.readObject();

					// Step 4: Gracefully close the streams
					objectStream.close();
					fileStream.close();
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return deserializeObject;
		}
	}
}

class Rectangle implements Serializable {
	private double height;
	private double width;

	public Rectangle(double height, double width) {
		super();
		this.height = height;
		this.width = width;
	}

	public double getArea() {
		return this.height * this.width;
	}

	public double getPerimeter() {
		return 2 * (this.height + this.width);
	}
}
