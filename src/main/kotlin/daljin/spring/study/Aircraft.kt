package daljin.spring.study

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import java.time.Instant

@JsonIgnoreProperties(ignoreUnknown = true)
class Aircraft(
    @Id
    val id: Long,

    val callSign: String,
    val squawk: String,
    val reg: String,
    val flightno: String,
    val route: String,
    val category: String,
    val altitude: Int,
    val heading: Int,
    val speed: Int,

    @JsonProperty("vert_rate")
    val vertRate: Int,

    @JsonProperty("selected_altitude")
    val selectedAltitude: Int,
    val lat: Double,
    val lon: Double,
    val barometer: Double,

    @JsonProperty("polar_distance")
    val polarDistance: Double,

    @JsonProperty("polar_bearing")
    val polarBearing: Double,

    @JsonProperty("is_adsb")
    val isADSB: Boolean,

    @JsonProperty("is_on_ground")
    val isOnGround: Boolean,

    @JsonProperty("last_seen_time")
    var lastSeenTime: Instant,

    @JsonProperty("pos_Update_time")
    var posUpdateTime: Instant,

    @JsonProperty("bds40_seen_time")
    var bds40SeenTime: Instant
) {
    fun setLastSeenTime(lastSeenTime: String) {
        this.lastSeenTime = Instant.parse(lastSeenTime)
    }
    fun getLastSeenTime() : String = this.lastSeenTime.toString()

    fun getPostUpdateTime(postLastTime: String) {
        this.posUpdateTime = Instant.parse(postLastTime)
    }
    fun getPostUpdateTime() = this.posUpdateTime.toString()

    fun getBds40SeenTime(bds40SeenTime: String) {
        this.bds40SeenTime = Instant.parse(bds40SeenTime)
    }
    fun getBds40SeenTime() : String = this.bds40SeenTime.toString()

}