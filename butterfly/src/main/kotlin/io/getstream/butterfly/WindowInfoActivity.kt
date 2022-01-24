/*
 * Copyright 2022 Stream.IO, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.getstream.butterfly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.window.layout.WindowLayoutInfo
import io.getstream.butterfly.internal.collectWindowLayoutInfo

/**
 * WindowInfoActivity tracks window configurations and update the [WindowLayoutInfo] by invoking
 * [onWindowLayoutInfoUpdated]. Also, provides a default property [windowSize] which includes
 * definition of the screen size.
 */
public abstract class WindowInfoActivity : ComponentActivity() {

    /** A definition of the screen size, this property will be initialized lazily. */
    protected val windowSize: WindowSize by lazy(LazyThreadSafetyMode.NONE) { getWindowSize() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Observes and collects the WindowLayoutInfo changes.
        collectWindowLayoutInfo(::onWindowLayoutInfoUpdated)
    }

    /** Invoked when the [WindowLayoutInfo] configuration changed. */
    protected abstract fun onWindowLayoutInfoUpdated(windowLayoutInfo: WindowLayoutInfo)
}
