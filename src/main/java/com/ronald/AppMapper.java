package com.ronald;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AppMapper extends Mapper <LongWritable, Text, Text, IntWritable>
{
    private Text palabra = new Text();
    private final static IntWritable uno = new IntWritable(1);
    
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
    {
        String linea = value.toString();
        String[] palabras = linea.split(" ");
        int size = palabras.length;
        
        for(int i=0; i<size; i++)
        {
            palabra.set(palabras[i]);
            context.write(palabra, uno);
        }
    }
}