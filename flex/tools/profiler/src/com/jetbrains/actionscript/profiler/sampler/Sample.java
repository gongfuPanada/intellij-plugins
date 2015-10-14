package com.jetbrains.actionscript.profiler.sampler;

/**
 * User: Maxim
 * Date: 04.09.2010
 * Time: 19:54:24
 */
public class Sample {
  public final FrameInfo[] frames;
  public final long duration;

  public Sample(long duration, FrameInfo[] frames) {
    this.duration = duration;
    this.frames = frames;
  }
}
