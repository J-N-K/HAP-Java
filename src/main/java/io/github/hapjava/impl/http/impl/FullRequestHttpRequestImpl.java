package io.github.hapjava.impl.http.impl;

import io.netty.handler.codec.http.FullHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FullRequestHttpRequestImpl extends DefaultHttpRequestImpl {
  Logger LOGGER = LoggerFactory.getLogger(FullRequestHttpRequestImpl.class);

  private final FullHttpRequest nettyRequest;

  public FullRequestHttpRequestImpl(FullHttpRequest nettyRequest) {
    super(nettyRequest);
    this.nettyRequest = nettyRequest;
  }

  @Override
  public byte[] getBody() {
    byte[] ret = new byte[nettyRequest.content().readableBytes()];
    nettyRequest.content().readBytes(ret);
    LOGGER.trace("received {}", ret);
    return ret;
  }
}
