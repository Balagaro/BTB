import androidx.wear.protolayout.TimelineBuilders.Timeline
import androidx.wear.protolayout.material.Text
import androidx.wear.tiles.TileBuilders.Tile

private val RESOURCES_VERSION = "1"
class MyTileService : TileService() {
    override fun onTileRequest(requestParams: RequestBuilders.TileRequest) =
        Futures.immediateFuture(Tile.Builder()
            .setResourcesVersion(RESOURCES_VERSION)
            .setTileTimeline(
                Timeline.fromLayoutElement(
                    Text.Builder(this, "Hello world!")
                        .setTypography(Typography.TYPOGRAPHY_DISPLAY1)
                        .setColor(argb(0xFF000000.toInt()))
                        .build()))
            .build())

    override fun onTileResourcesRequest(requestParams: ResourcesRequest) =
        Futures.immediateFuture(Resources.Builder()
            .setVersion(RESOURCES_VERSION)
            .build()
        )
}