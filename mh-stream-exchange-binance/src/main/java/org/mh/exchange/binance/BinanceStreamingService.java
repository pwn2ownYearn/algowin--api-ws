package org.mh.exchange.binance;

import com.fasterxml.jackson.databind.JsonNode;
import org.mh.service.netty.JsonNettyStreamingService;
import org.mh.stream.exchange.core.ProductSubscription;

import java.io.IOException;

public class BinanceStreamingService extends JsonNettyStreamingService {

  private final ProductSubscription productSubscription;

  public BinanceStreamingService(String baseUri, ProductSubscription productSubscription) {
    super(baseUri, Integer.MAX_VALUE);
    this.productSubscription = productSubscription;
  }

  @Override
  public void messageHandler(String message) {
    super.messageHandler(message);
  }

  @Override
  protected void handleMessage(JsonNode message) {
    super.handleMessage(message);
  }

  @Override
  protected String getChannelNameFromMessage(JsonNode message) throws IOException {
    return message.get("stream").asText();
  }

  @Override
  public String getSubscribeMessage(String channelName, Object... args) throws IOException {
    // 没有操作。从web套接字断开连接将取消订阅。
    return null;
  }

  @Override
  public String getUnsubscribeMessage(String channelName) throws IOException {
    // No op. Disconnecting from the web socket will cancel subscriptions.
    return null;
  }

  @Override
  public void sendMessage(String message) {
    // Subscriptions are made upon connection - no messages are sent.
  }

  /**
   * The available subscriptions for this streaming service.
   *
   * @return The subscriptions for the currently open connection.
   */
  public ProductSubscription getProductSubscription() {
    return productSubscription;
  }
}
