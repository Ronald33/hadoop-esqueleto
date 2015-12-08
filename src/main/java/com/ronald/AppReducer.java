package com.ronald;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

class AppReducer extends Reducer<Text, IntWritable, Text, IntWritable>
{
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
    {
        int contador = 0;
        
        for(IntWritable valor : values)
        {
            contador += valor.get();
        }
        
        //context.write(key, new IntWritable(contador));
    }
}