redis = require 'redis'
client = redis.createClient()

CHANNEL = 'pubsubtest'

setInterval(
  ->
    client.publish CHANNEL, 'test-message'
    return
  1000
)
