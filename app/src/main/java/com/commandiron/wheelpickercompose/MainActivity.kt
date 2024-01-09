package com.commandiron.wheelpickercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.wheel_picker_compose.WheelTimePicker
import com.commandiron.wheel_picker_compose.core.TimeFormat
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.commandiron.wheelpickercompose.ui.theme.WheelPickerComposeTheme
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WheelPickerComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        var changeableTime: LocalTime by remember {
                            mutableStateOf(LocalTime.now())
                        }
                        WheelTimePicker(
                            startTime = changeableTime,
                            timeFormat = TimeFormat.HOUR_24,
                            size = DpSize(200.dp, 100.dp),
                            rowCount = 5,
                            textStyle = MaterialTheme.typography.titleSmall,
                            textColor = Color(0xFFffc300),
                            selectorProperties = WheelPickerDefaults.selectorProperties(
                                enabled = true,
                                shape = RoundedCornerShape(0.dp),
                                color = Color(0xFFf1faee).copy(alpha = 0.2f),
                                border = BorderStroke(2.dp, Color(0xFFf1faee))
                            )
                        ){ snappedDateTime ->
                            // updatedTime = snappedDateTime
                        }

                        Button(onClick = {
                            changeableTime = LocalTime.now()
                        }) {
                            Text(text = "Set time to now")
                        }
                    }
                }
            }
        }
    }
}